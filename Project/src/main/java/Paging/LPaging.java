package Paging;

import java.util.ArrayList;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LPaging {
	private int pageTotal;
	private int onePageLimit;
	private int pageAll;
	private int bottomList;
	private int startBtn;
	private int endBtn;
	private int currentBtn;
	private int pstartno;
	private ArrayList <LDto> list10;
	public LPaging() {
	}
	
	public LPaging(int pstartno) {
		LDao dao = new LDao();
		// # 전체 레코드 수: 768	private int pageTotal;
		this.pageTotal = dao.pagingListAll();
		// # 한페이지당 보여주는 레코드 수: 10	private int onePageLimit;
		this.onePageLimit = 10;
		// # 전체페이지수: 76	private int pageAll;
		this.pageAll = (int) Math.ceil(pageTotal/(float)onePageLimit);
		// # 하단 네비게이션: 10		private int bottomList;
		this.bottomList = 10;
		// # 현재 보여줄 db시작번호	private int pstartno;
		this.pstartno = pstartno;
		// # 현재 보여줄 10개 페이지	private ArrayList <JstlitemDto> list10;
		this.list10 = dao.pagingListPage(pstartno);
		// # 현재버튼	private int currentBtn;
		this.currentBtn = (int) Math.ceil((pstartno+1)/(float) onePageLimit);
		// # 시작버튼	private int startBtn;
		this.startBtn = ((int) Math.floor((this.currentBtn-1)/(float)this.bottomList))*bottomList+1;
		// # 끝버튼	private int endBtn;
		this.endBtn = this.startBtn + bottomList-1;
		
		
		
		if(this.pageAll <this.endBtn) {this.endBtn = this.pageAll;}
	}
	
	public LPaging(int pageTotal, int onePageLimit, int pageAll, int bottomList, int startBtn, int endBtn,
			int currentBtn, ArrayList<LDto> list10, int pstartno) {
		super();
		this.pageTotal = pageTotal;
		this.onePageLimit = onePageLimit;
		this.pageAll = pageAll;
		this.bottomList = bottomList;
		this.startBtn = startBtn;
		this.endBtn = endBtn;
		this.currentBtn = currentBtn;
		this.list10 = list10;
		this.pstartno = pstartno;
	}
	@Override
	public String toString() {
		return "JstlPaging [pageTotal=" + pageTotal + ", onePageLimit=" + onePageLimit + ", pageAll=" + pageAll
				+ ", bottomList=" + bottomList + ", startBtn=" + startBtn + ", endBtn=" + endBtn + ", currentBtn="
				+ currentBtn + ", list10=" + list10 + ", pstartno=" + pstartno + "]";
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public int getOnePageLimit() {
		return onePageLimit;
	}
	public void setOnePageLimit(int onePageLimit) {
		this.onePageLimit = onePageLimit;
	}
	public int getPageAll() {
		return pageAll;
	}
	public void setPageAll(int pageAll) {
		this.pageAll = pageAll;
	}
	public int getBottomList() {
		return bottomList;
	}
	public void setBottomList(int bottomList) {
		this.bottomList = bottomList;
	}
	public int getStartBtn() {
		return startBtn;
	}
	public void setStartBtn(int startBtn) {
		this.startBtn = startBtn;
	}
	public int getEndBtn() {
		return endBtn;
	}
	public void setEndBtn(int endBtn) {
		this.endBtn = endBtn;
	}
	public int getCurrentBtn() {
		return currentBtn;
	}
	public void setCurrentBtn(int currentBtn) {
		this.currentBtn = currentBtn;
	}
	public ArrayList<LDto> getList10() {
		return list10;
	}
	public void setList10(ArrayList<LDto> list10) {
		this.list10 = list10;
	}
	public int getPstartno() {
		return pstartno;
	}
	public void setPstartno(int pstartno) {
		this.pstartno = pstartno;
	}
}
