package com.sun.power.core.common.entity;

import com.sun.power.core.common.constant.SysConstant;
import lombok.Data;

import java.util.List;

/**  
* 类说明   
*  
* @author 贾涛
* @date 2018年8月29日  新建  
*/
@Data
public class PageBean<T>{
    // 当前页
    private Integer currentPage ;
    // 每页显示的总条数
    private Integer pageSize ;
    // 总条数
    private Integer totalNum;
    // 是否有下一页
    private Integer isMore;
    // 总页数
    private Integer totalPage;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> items;
    
    public PageBean() {
        super();
    }
    
    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        super();
        this.currentPage    = currentPage;
        this.pageSize       = pageSize;
        if( pageSize == null || currentPage == null || pageSize == 0 || currentPage == 0){
        	
            this.currentPage = SysConstant.DEFAULT_CURRENT_PAGE;
            this.pageSize = SysConstant.DEFAULT_PAGE_SIZE;
        }
        this.totalNum       = totalNum;
        this.totalPage      = (this.totalNum+this.pageSize-1)/this.pageSize;
        this.startIndex     = (this.currentPage-1)*this.pageSize;
        this.isMore         = this.currentPage >= this.totalPage?0:1;
    }
}
