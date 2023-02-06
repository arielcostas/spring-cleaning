package dev.costas.librosautor.infra.params;

public class PageParams {
	private Integer limit = 10;
	private Integer page = 0;

	public PageParams() {
	}

	public PageParams(Integer limit, Integer page) {
		this.limit = limit;
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public Integer getPage() {
		return page;
	}
}
