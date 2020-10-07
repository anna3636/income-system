package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="works")
@NamedQueries({
    @NamedQuery(
            name="getAllWorks",
            query="SELECT w FROM Work As w ORDER BY w.id DESC"
            ),
    @NamedQuery(
            name="getWorksCount",
            query="SELECT COUNT(w) FROM Work AS w"
            ),
    @NamedQuery(
            name="checkLoginNameAndPassword",
            query="SELECT w FROM Work AS w WHERE w.delete_flag=0 AND w.name= :name AND w.password= :sign"
            ),
    @NamedQuery(
            name="checkRegisteredName",
            query="SELECT COUNT(w) FROM Work AS w WHERE w.name=:name"
            )
})
@Entity
public class Work {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name",nullable=false,unique=true)
    private String name;

    @Column(name="password",length=64,nullable=false)
    private String password;

   /* @Column(name="income",nullable=false)
    private Integer income;

    @Column(name="work_date")
    private Date work_date;

    @Column(name="title", nullable=false)
    private String title;

    @Column(name="content")
    private String content; */

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;
   /* @Column(name="work_name",nullable=false)
    private String work_name; */

    @Column(name = "admin_flag", nullable = false)
    private Integer admin_flag;


    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
  /*  public Integer getIncome(){
        return income;
    }
    public void setIncome(Integer income){
        this.income=income;
    }
    public Date getWork_date(){
        return work_date;
    }
    public void setWork_date(Date work_date){
        this.work_date=work_date;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getContent(){
        return content;
    }
    public void setContent(String content){
        this.content=content;
    }*/
    public Integer getDelete_flag(){
        return delete_flag;
    }
    public void setDelete_flag(Integer delete_flag){
        this.delete_flag = delete_flag;
    }
  /*  public String getWork_name(){
        return work_name;
    }
    public void setWork_name(String work_name){
        this.work_name=work_name;
    } */

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

}
