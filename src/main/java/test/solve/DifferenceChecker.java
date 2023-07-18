package test.solve;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
public class DifferenceChecker {
    private Hashtable<String, String> yesterdayData;
    private Hashtable<String, String> todayData;
    private LinkedList<String> disappeared;
    private LinkedList<String> appeared;
    private LinkedList<String> changed;
    public DifferenceChecker(){
        yesterdayData = new Hashtable<>();
        todayData = new Hashtable<>();
        disappeared = new LinkedList<>();
        appeared = new LinkedList<>();
        changed = new LinkedList<>();
    }
    public boolean startChecking(){
        this.fillWithPreparedData();
        if(this.checkDifference()){
            return true;
        }else {
            return false;
        }
    }
    //If there were data to get
    private void getData(){

    }
    private void fillWithPreparedData() {
        yesterdayData.put("https://www.google.com", "htmlcode1");
        yesterdayData.put("https://www.youtube.com", "htmlcode2");
        yesterdayData.put("https://www.twitter.com", "htmlcode3");
        yesterdayData.put("https://www.twitch.tv", "htmlcode4");
        yesterdayData.put("https://www.vk.com", "htmlcode5");
        yesterdayData.put("https://www.hh.ru", "htmlcode6");

        todayData.put("https://www.google.com", "htmlcode");
        todayData.put("https://www.youtube.com", "htmlcode2");
        todayData.put("https://www.twitch.tv", "htmlcode");
        todayData.put("https://www.vk.com", "htmlcode5");
        todayData.put("https://www.hh.ru", "htmlcode6");
        todayData.put("https://www.ok.ru", "htmlcodelast");
    }
    /**
     * Method that checks difference between today's and yesterday's data and if there
     * are any changes we add url to specified linkedlist
    @return result of checking, true if any changes were located, false otherwise
     */
    private boolean checkDifference(){
        for(Map.Entry data:yesterdayData.entrySet()){
            String url = (String) data.getKey();
            String htmlCode = todayData.get(url);
            //If result is null means that today data has no url which was yesterday (this url is data.key)
            //So we need to add it to disappeared list
            if(htmlCode == null){
                disappeared.add(url);
            }
        }

        for(Map.Entry data:todayData.entrySet()){
            String url = (String) data.getKey();
            String htmlCode = yesterdayData.get(url);

            //If result is null means that yesterday data has no url which we have today (this url is data.key)
            //So we need to add it to appeared list
            if(htmlCode != null) {
                if(!htmlCode.equals(data.getValue())){
                    changed.add(url);
                }
            }
            else {
                appeared.add(url);
            }
        }

        if(disappeared.size() == 0 && appeared.size() == 0 && changed.size() == 0){
            return false;
        }
        return true;
    }
    public String getDisappearedListInString(){
        return disappeared.toString();
    }
    public String getAppearedListInString(){
        return appeared.toString();
    }
    public String getChangedListInString(){
        return changed.toString();
    }
}
