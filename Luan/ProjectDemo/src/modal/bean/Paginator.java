package modal.bean;

import java.util.List;

import javax.faces.component.UICommand;
import javax.faces.event.ActionEvent;

import modal.dao.UserDao;

public class Paginator {
	private static final int DEFAULT_RECORDS_NUMBER = 2;
//	private static final int DEFAULT_PAGE_INDEX = 1;
	private static final int DEFAULT_PAGE_RANGE = 2;
	
	UserBean userBean =  new UserBean();
	UserDao dao = new UserDao();
	private List<UserBean> list;
	private int totalRows;
	private int firstRow;
	private int rowsPerPage;
	private int totalPages;
	private int pageRange;
	private Integer[] pages;
	private int currentPage;
	
	public Paginator() {
		rowsPerPage = DEFAULT_RECORDS_NUMBER;
		pageRange = DEFAULT_PAGE_RANGE;
	}
	
	public List<UserBean> getListUser() {
		if (list == null) {
			loadUserList();
		}
		
		return list;

	}
	private void loadUserList() {
		list =  dao.showAllUserInPage(firstRow, rowsPerPage);
		totalRows = dao.Count();
		currentPage = (totalRows / rowsPerPage) - ((totalRows - firstRow)/rowsPerPage)+1;
		totalPages = (totalRows / rowsPerPage) + ((totalRows % rowsPerPage != 0) ? 1 : 0);
		int pagesLength = Math.min(pageRange, totalPages);

		int firstPage = Math.min(Math.max(0, currentPage - (pageRange / 2)), totalPages - pagesLength);

		for (int i = 0; i < pagesLength; i++) {
		pages[i] = ++firstPage;
		}
	}
	
	private void page(int firstRow) {
		this.firstRow = firstRow;
		loadUserList(); // Load requested page.
		}
	public void page(ActionEvent event) {
		page(((Integer) ((UICommand) event.getComponent()).getValue() - 1) * rowsPerPage);
		
		}

	public int getTotalRows() {
		return totalRows;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public int getRowsPerPage() {
		return rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public int getPageRange() {
		return pageRange;
	}

	public Integer[] getPages() {
		return pages;
	}


	public int getCurrentPage() {
		return currentPage;
	}

}
