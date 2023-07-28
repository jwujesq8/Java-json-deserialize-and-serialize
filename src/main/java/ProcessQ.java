public class ProcessQ {

    HttpQueryClass queryClass;

    public ProcessQ(HttpQueryClass queryClass) {
        this.queryClass = queryClass;
    }

    public String process(String param, String link) {
        return queryClass.query(param, link);
    }

}