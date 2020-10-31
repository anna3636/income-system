package models.validators;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Work;
import utils.DBUtil;

public class WorkValidator {
  public static List<String> validate(Work w, Boolean nameDuplicateCheckFlag,
      Boolean passwordCheckFlag) {
    List<String> errors = new ArrayList<String>();

    String nameError = _validateName(w.getName(), nameDuplicateCheckFlag);
    if (!nameError.equals("")) {
      errors.add(nameError);
    }

    String passwordError = _validatePassword(w.getPassword(), passwordCheckFlag);
    if (!passwordError.equals("")) {
      errors.add(passwordError);
    }
    return errors;

  }

  // ユーザー名
  private static String _validateName(String name, Boolean nameDuplicateCheckFlag) {
    if (name == null || name.equals("")) {
      return "ユーザーネームを入力してください";
    }
    // すでに入力されているユーザー名との重複チェック
    if (nameDuplicateCheckFlag) {
      EntityManager em = DBUtil.createEntityManager();
      long worksCount = (long) em.createNamedQuery("checkRegisteredName", Long.class)
          .setParameter("name", name).getSingleResult();
      em.close();
      if (worksCount > 0) {
        return "入力されたユーザー名はすでに存在します";
      }
    }
    return "";

  }

  // パスワードの必須入力チェック
  private static String _validatePassword(String password, Boolean passwordCheckFlag) {
    // パスワードを変更する場合のみ実行
    if (passwordCheckFlag && (password == null || password.equals(""))) {
      return "パスワードを入力してください";

    }
    return "";
  }

}
