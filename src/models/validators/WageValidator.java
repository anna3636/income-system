package models.validators;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import models.Wage;

public class WageValidator {
  public static List<String> validate(Wage a) {
    List<String> errors = new ArrayList<String>();

    String workNameError = _validateWorkName(a.getWorkName());
    if (!workNameError.equals("")) {
      errors.add(workNameError);
    }

    String contentError = _validateContent(a.getContent());
    if (!contentError.equals("")) {
      errors.add(contentError);
    }
    String incomeError = _validateIncome(a.getIncome());
    if (!incomeError.equals("")) {
      errors.add(incomeError);
    }


    String workDateError = _validateWorkDate(a.getWorkDate());
    if (!workDateError.equals("")) {
      errors.add(workDateError);
    }

    return errors;
  }

  private static String _validateWorkName(String workName) {
    if (workName == null || workName.equals("")) {
      return "バイト名を入力してください";
    }
    return "";
  }

  private static String _validateContent(String content) {
    if (content == null || content.equals("")) {
      return "内容を入力してください";
    }
    return "";
  }

  // 収入の必須入力チェック
  private static String _validateIncome(Integer income) {
    if (income == null || income.equals("")) {
      return "収入を入力してください";
    }
    return "";
  }

  private static String _validateWorkDate(Date workDate) {
    if (workDate == null || workDate.equals("")) {
      return "日付を入力してください";
    }
    return "";
  }

}
