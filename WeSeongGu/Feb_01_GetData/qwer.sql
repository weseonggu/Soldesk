create table feb01_weather(
	w_MSRDT date not null,
	w_MSRRGN_NM varchar2(5 char) not null,
	w_MSRSTE_NM varchar2(5 char) not null,
	w_PM10 number(4) not null,
	w_pm25 number(4) not null,
	w_O3 number(5,3) not null,
	w_IDEX_NM varchar2(5 char)not null
);

drop table feb01_weather;

select * from FEB01_WEATHER;

select w_MSRSTE_NM, avg(w_PM10+ w_pm25) from FEB01_WEATHER group by w_MSRSTE_NM 
order by avg(w_PM10+ w_pm25) desc