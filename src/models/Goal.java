package models;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "goals")
@NamedQueries({
    @NamedQuery(name = "getAllMyGoal",
        query = "SELECT g FROM Goal AS g WHERE g.work= :work ORDER BY g.id DESC"),
    @NamedQuery(name = "getMaxGoal",
        query = "SELECT MAX(g.targetAmount) FROM Goal AS g WHERE g.work= :work ORDER BY g.id DESC")})
@Entity
public class Goal {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "work_id", nullable = false)
  private Work work;

  @Column(name = "targetAmount")
  private Integer targetAmount;

  @Column(name = "purpose")
  private String purpose;

  @Column(name = "created_at", nullable = false)
  private Timestamp created_at;

  @Column(name = "updated_at", nullable = false)
  private Timestamp updated_at;

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

  public Integer getTargetAmount() {
    return targetAmount;
  }

  public void setTargetAmount(Integer targetAmount) {
    this.targetAmount = targetAmount;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public Timestamp getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Timestamp created_at) {
    this.created_at = created_at;
  }

  public Timestamp getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(Timestamp updated_at) {
    this.updated_at = updated_at;
  }

}
