package yaycrawler.dao.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yuananyun on 2016/5/1.
 */
@Entity
@Table(name = "conf_page_region")
public class PageParseRegion implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String id;
    @Column(name = "pageId",nullable = false,columnDefinition = "varchar(38)")
    private String pageId;
//    @NotNull
//    @Column(name = "pageUrl")

    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "dataType",nullable = false,columnDefinition = "varchar(38) default 'MAP'")
    private String dataType;

    /**
     * 区域选择表达式
     */
    @Column(name = "selectExpression",columnDefinition = "varchar(100)")
    private String selectExpression;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", insertable = false, updatable = false)
    private List<FieldParseRule> fieldParseRules;

    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", insertable = false, updatable = false)
    @OrderBy(value = "id ASC")
    private List<UrlParseRule> urlParseRules;
    @Column(name = "createdDate",columnDefinition = "timestamp default now()")
    private Date createdDate;

    public PageParseRegion() {
        fieldParseRules = new LinkedList<>();
        urlParseRules = new LinkedList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSelectExpression() {
        return selectExpression;
    }

    public void setSelectExpression(String selectExpression) {
        this.selectExpression = selectExpression;
    }

    public List<FieldParseRule> getFieldParseRules() {
        return fieldParseRules;
    }

    public void setFieldParseRules(List<FieldParseRule> fieldParseRules) {
        this.fieldParseRules = fieldParseRules;
    }

    public List<UrlParseRule> getUrlParseRules() {
        return urlParseRules;
    }

    public void setUrlParseRules(List<UrlParseRule> urlParseRules) {
        this.urlParseRules = urlParseRules;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
