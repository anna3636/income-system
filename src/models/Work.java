package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name = "works")
@NamedQueries({
    @NamedQuery(name = "getAllWorks", query = "SELECT w FROM Work As w ORDER BY w.id DESC"),
    @NamedQuery(name = "getWorksCount", query = "SELECT COUNT(w) FROM Work AS w"),
    @NamedQuery(name = "checkLoginNameAndPassword",
        query = "SELECT w FROM Work AS w WHERE w.delete_flag=0 AND w.name= :name AND w.password= :sign"),
    @NamedQuery(name = "checkRegisteredName",
        query = "SELECT COUNT(w) FROM Work AS w WHERE w.name=:name")})
@Entity
public class Work {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false, unique = true)
  private String name;

  @Column(name = "password", length = 64, nullable = false)
  private String password;

  @Column(name = "delete_flag", nullable = false)
  private Integer delete_flag;

  @Column(name = "adminFlag", nullable = false)
  private Integer adminFlag;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public Integer getDelete_flag() {
    return delete_flag;
  }

  public void setDelete_flag(Integer delete_flag) {
    this.delete_flag = delete_flag;
  }

  public Integer getAdminFlag() {
    return adminFlag;
  }

  public void setAdminFlag(Integer adminFlag) {
    this.adminFlag = adminFlag;
  }

}
