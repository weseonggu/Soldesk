package com.we.miniproject.dataroom;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.we.miniproject.BPBACPValue;
import com.we.miniproject.member.Member;

@Service
public class DataDAO {
	private int dataCount;
	
	@Autowired
	private SqlSession ss;
	@Autowired
	private BPBACPValue bo;
	
	//파일 가져 오기
	public void showData(HttpServletRequest req) {
		try {
			int page = (int) Math.ceil((double)dataCount/bo.getDataroomFilePerpage());
			int p;
			try {
				p = Integer.parseInt( req.getParameter("p"));				
			} catch (Exception e) {
				p=1;
			}
			int end = p*bo.getDataroomFilePerpage();
			int start = end - (bo.getDataroomFilePerpage()-1);
//			System.out.println(start);
//			System.out.println(end);
			
			HashMap<String, String> con = new HashMap<String, String>();
			con.put("start", start+"");
			con.put("end",end+"");
			
			List<DataInfo> datas = ss.getMapper(DataMapper.class).getData(con);
			req.setAttribute("pages", page);
			req.setAttribute("datas", datas);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//자료수 새기
	public void getDataCount() {
		dataCount = ss.getMapper(DataMapper.class).getDataCount();
	}
	
	// 파일 올리기
	public void uploadFile(HttpServletRequest req, DataInfo di,RedirectAttributes re) {
		String path = req.getSession().getServletContext().getRealPath("resources/Data");
		MultipartRequest mr = null;
		// 사진 오류 검사 
		try {
			mr = new MultipartRequest(req, path, 10485760, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			re.addFlashAttribute("result","업로드 실패(파일오류)");
			File f = new File(path + "/" + mr.getFilesystemName("bd_title"));
			f.delete();
			return;
			// 파일 오류
		}
		
		//새로 고침
		String token = mr.getParameter("token");
		String lastToken  = (String)req.getSession().getAttribute("successToken");
		
		if(lastToken!=null || token.equals(lastToken)) {
			re.addFlashAttribute("result","업로드 실패(새로고침)");
			File f = new File(path + "/" + mr.getFilesystemName("bd_title"));
			f.delete();
			return;
		}

		
		// 사지 오류없으면 db작업
		try {
			Member m  = (Member)req.getSession().getAttribute("loginMember");
			String bd_uploader = m.getBm_id();
			String bd_title = mr.getParameter("bd_title");
			String bd_file = mr.getFilesystemName("bd_file");
			bd_file = URLEncoder.encode(bd_file, "utf-8");
			bd_file = bd_file.replace("+", " ");
//			System.out.println(bd_uploader);
//			System.out.println(bd_title);
//			System.out.println(bd_file);
			
			di.setBd_uploader(bd_uploader);
			di.setBd_title(bd_title);
			di.setBd_file(bd_file);
			if(ss.getMapper(DataMapper.class).upload(di)==1) {
				re.addFlashAttribute("result","업로드 성공");
				dataCount++;
			}
			
		} catch (Exception e) {
			re.addFlashAttribute("result","업로드 실패");
			File f = new File(path + "/" + mr.getFilesystemName("bd_title"));
			f.delete();
			e.printStackTrace();
		}
	}
	//다운로드
	public void download(HttpServletRequest req, HttpServletResponse res, DataInfo di) {
		FileInputStream fis = null;// 파일에 있는거 꺼낼때 쓰는 빨대(1바이트씩) 바이트 다윈로만 읽어 들이기 때문에 다른 거 필요없음
		ServletOutputStream sos = null; // 클라이언트한태 음답할떄 쓰는 빨대(1바이트)
		try {
			String path = req.getSession().getServletContext().getRealPath("resources/Data");
			// 한글처리 되어있는 파일명  %2A.png utf-8로 안코딩한거
			String fileName = req.getParameter("file");
			// 한글처리 풀린 파일명       ㅋ.png
			String decodingFileName = URLDecoder.decode(fileName, "utf-8");
			// 쌩자바로 파일에서 읽어내서 
			//tomcat+jsp로 응답
			
			fis =  new FileInputStream(path+"/"+decodingFileName);
			res.reset();// 기존 응답 지우기
			// 파일 다운 시켜주는 응답
			res.setContentType("application/octet-stream");
			res.setHeader("Content-Disposition", "attachment; filename="+fileName);
			sos=res.getOutputStream();
			
			// fis로 파일에서  읽어내서, sos호 전송
			//(파일에 들어있는 데이터 읽어서, 클라이언트에게 전송)
			
			byte[] b = new byte[4096];// 4키로 바이트씩 앍어서 저장
			int data =0;
				// 0:저음부터
				// b.length: 4096개
				// 읽어서 b에다 저장
				// 그거를 int로 변환햐서 data에 저장
				// data에 뭐가 없을떄까지 진행
			while((data = fis.read(b, 0, b.length))!=-1) {
				sos.write(b, 0, b.length);
			}
			sos.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			sos.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
