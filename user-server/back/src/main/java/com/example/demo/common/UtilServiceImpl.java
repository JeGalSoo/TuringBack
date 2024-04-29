package com.example.demo.common;

import lombok.Getter;

public class UtilServiceImpl implements UtilService {

    @Getter
    private static UtilServiceImpl instance = new UtilServiceImpl();

    private UtilServiceImpl(){}

    @Override
    public int createRandomInteger(int min, int max) {

        return min + (int)(Math.random()*(max-min));
    }

    @Override
    public double createRandomDouble(double min, double max){

        return Math.round((min +
                (Math.random()*(max-min)))*10)/10.0;
    }

    public String createRandomName(){
        String[] names = {"이정재", "마동석", "송강호", "윤여정", "황정민",
                "정우성", "이병헌", "현 빈", "유해진", "손석구",
                "전도연", "손예진", "하지원", "김하늘", "송중기",
                "하정우", "장동건", "원 빈", "박해일", "소지섭", "김혜수"};
        return names[createRandomInteger(0,20)];
    }
    @Override
    public String createRandomTitle() {
        String[] titles = {
                "정부", "국회", "위원", "국군", "대통령", "국무총리", "대한민국", "헌법재판소",
                "여자의 근로", "고용·임금 및 근로조건", "모든 국민", "의무교육", "국가"
        };
        return titles[createRandomInteger(0,12)];
    }

    @Override
    public String createRandomContent() {
        String[] content = {
                "정부는 회계연도마다 예산안을 편성하여 회계연도 개시 90일전까지 국회에 제출하고,",
                "국회는 회계연도 개시 30일전까지 이를 의결하여야 한다.",
                "위원은 탄핵 또는 금고 이상의 형의 선고에 의하지 아니하고는 파면되지 아니한다.",
                "국군은 국가의 안전보장과 국토방위의 신성한 의무를 수행함을 사명으로 하며, 그 정치적 중립성은 준수된다.",
                "대통령은 제1항과 제2항의 처분 또는 명령을 한 때에는 지체없이 국회에 보고하여 그 승인을 얻어야 한다.",
                "대통령은 국무총리·국무위원·행정각부의 장 기타 법률이 정하는 공사의 직을 겸할 수 없다.",
                "대한민국의 경제질서는 개인과 기업의 경제상의 자유와 창의를 존중함을 기본으로 한다.",
                "헌법재판소는 법관의 자격을 가진 9인의 재판관으로 구성하며, 재판관은 대통령이 임명한다.",
                "여자의 근로는 특별한 보호를 받으며,",
                "고용·임금 및 근로조건에 있어서 부당한 차별을 받지 아니한다.",
                "모든 국민은 법률이 정하는 바에 의하여 국방의 의무를 진다.",
                "의무교육은 무상으로 한다",
                "국가는 농수산물의 수급균형과 유통구조의 개선에 노력하여 가격안정을 도모함으로써 농·어민의 이익을 보호한다."
        };
        return content[createRandomInteger(0,12)];
    }

    @Override
    public String createRandomCompany() {
        String[] companies = {"구글","엔비디아","네이버","삼성","LG","애플"};
        return companies[createRandomInteger(0,5)];
    }

    @Override
    public String createRandomJob() {
        String[] jobs = {"경찰","개발자","선생님","소방관","백수","물리치료사"};
        return jobs[createRandomInteger(0,5)];
    }

    @Override
    public String createRandomUsername() {
        String username = "";
            for(; username.length() < 5;
                username += String.valueOf((char)('a' + this.createRandomInteger(0,26))));     //i++자리에 바로 할당, a 아스키코드는 97이므로 97+26 = z이다.

            return username;

    }


}
