package com.nowcoder.community.model.vo;

import java.io.Serializable;

/**
 * @author: jellmo
 * @date: 2022/12/2 23:06
 */
public class PageVo implements Serializable {

    /**
     * 当前页, 默认第一页
     **/
    private int current = 1;
    /**
     * 每页显示条数, 默认10条
     **/
    private int limit = 10;
    /**
     * 总记录数
     **/
    private int rows;
    /**
     * 页面路径，实际上不带也可，这里定义是为了方便thymeleaf复用
     **/
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current > 0) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit > 0 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows > 0) {
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取数据库查询起始行
     *
     * @return (current - 1)*limit
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getTotal() {
        return rows % limit == 0 ? rows / limit : rows / limit + 1;
    }

    //from和to 定义页码范围，每次只显示相邻5页

    /**
     * 获取起始页
     *
     * @return 起始页
     */
    public int getFrom() {
        return Math.max((current - 2), 1);
    }

    /**
     * 获取终止页
     *
     * @return 终止页
     */
    public int getTo() {
        int total = getTotal();
        return Math.min(current + 2, total);
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }
}
