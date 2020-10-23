package models.validators;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import models.Work;
import utils.DBUtil;

public class WorkValidator {
  public static List<String> validate(Work w, Boolean name_duplicate_check_flag,
      Boolean password_check_flag) {
    List<String> errors = new ArrayList<String>();

    String name_error = _validateName(w.getName(), name_duplicate_check_flag);
    if (!name_error.equals("")) {
      errors.add(name_error);
    }

    String password_error = _validatePassword(w.getPassword(), password_check_flag);
    if (!password_error.equals("")) {
      errors.add(password_error);
    }
    return errors;

  }

  // ユーザー名
  private static String _validateName(String name, Boolean name_duplicate_check_flag) {
    if (name == null || name.equals("")) {
      return "ユーザーネームを入力してください";
    }
    // すでに入力されているユーザー名との重複チェック
    if (name_duplicate_check_flag) {
      EntityManager em = DBUtil.createEntityManager();
      long works_count = (long) em.createNamedQuery("checkRegisteredName", Long.class)
          .setParameter("name", name).getSingleResult();
      em.close();
      if (works_count > 0) {
        return "入力されたユーザー名はすでに存在します";
      }
    }
    return "";

  }

  // パスワードの必須入力チェック
  private static String _validatePassword(String password, Boolean password_check_flag) {
    // パスワードを変更する場合のみ実行
    if (password_check_flag && (password == null || password.equals(""))) {
      return "パスワードを入力してください";

    }
    return "";
  }

}
