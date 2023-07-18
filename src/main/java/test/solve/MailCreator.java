package test.solve;

public class MailCreator {
   private DifferenceChecker differenceChecker;
   private String name;
   public MailCreator(){
      this.differenceChecker = new DifferenceChecker();
   }
   public MailCreator(String name){
      this.differenceChecker = new DifferenceChecker();
      this.name = name;
   }
   public String createMessage(){
      StringBuilder sb = new StringBuilder("Здравствуйте, дорогая ");
      sb.append(name);
      if(differenceChecker.startChecking()) {
         sb.append("\n\nЗа последние сутки во вверенных Вам сайтах произошли следующие изменения:\n\n");
         sb.append("Исчезли следующие страницы:");
         sb.append(differenceChecker.getDisappearedListInString());
         sb.append("\nПоявились следующие новые страницы:");
         sb.append(differenceChecker.getAppearedListInString());
         sb.append("\nИзменились следующие страницы:");
         sb.append(differenceChecker.getChangedListInString());
      } else {
         sb.append("\n\nЗа последние сутки во вверенных Вам сайтах изенений не произошло:");
      }

      sb.append("\n\nС уважением,\n" +
              "автоматизированная система\n" +
              "мониторинга.");
      return sb.toString();
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
