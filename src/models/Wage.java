package models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "wages")
@NamedQueries({
    @NamedQuery(name = "getAllWages", query = "SELECT a FROM Wage AS a ORDER BY a.id DESC"),
    @NamedQuery(name = "getMyAllWages",
        query = "SELECT a FROM Wage AS a WHERE a.work = :work ORDER BY a.id DESC"),
    @NamedQuery(name = "wageCount", query = "SELECT COUNT(a) FROM Wage AS a"),
    @NamedQuery(name = "sumMyAllIncome",
        query = "SELECT SUM(a.income) FROM Wage AS a WHERE a.work = :work ORDER BY a.id DESC")})

@Entity
public class Wage {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "work_id", nullable = false)
  private Work work;

  @Column(name = "work_name", nullable = false)
  private String work_name;

  @Column(name = "work_date", nullable = false)
  private Date work_date;

  @Column(name = "income", nullable = false)
  private Integer income;

  @Lob
  @Column(name = "content", nullable = false)
  private String content;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Work getWork() {
    return work;
  }

  public void setWork(Work work) {
    this.work = work;
  }

  public String getWork_name() {
    return work_name;
  }

  public void setWork_name(String work_name) {
    this.work_name = work_name;
  }

  public Date getWork_date() {
    return work_date;
  }

  public void setWork_date(Date work_date) {
    this.work_date = work_date;
  }

  public Integer getIncome() {
    return income;
  }

  public void setIncome(Integer income) {
    this.income = income;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}
