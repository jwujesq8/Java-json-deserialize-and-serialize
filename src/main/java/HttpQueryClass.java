import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
public class HttpQueryClass {
    public String query(String param, String link){
        String result=null;
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(link);
        request.addHeader("custom-key", "programming");

        try (CloseableHttpResponse response = httpclient.execute(request)) {

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);
            if (entity != null) {
                result = EntityUtils.toString(entity);
            }
        } catch (ClientProtocolException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("time out..");
            return result;
            //throw new RuntimeException(e);
        }
        return result + param;
    }
}
