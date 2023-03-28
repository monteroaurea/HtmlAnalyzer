import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class HtmlAnalyzer 

{

    private static class HtmlFetcher {
        public static String getHtml(String urlString) throws IOException {
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder html = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                html.append(line);
                html.append("\n");
            }
            reader.close();

            return html.toString();

        }
}


    public static void main(String[] args) {
        String url = args[0];
        String html = null;
        try {
            html = HtmlFetcher.getHtml(url);
        } catch (IOException e) {
            System.err.println("URL connection error");
        }

        Stack<String> tagStack = new Stack<>();
        String deepestHtml = null;
        int deepestLevel = -1;
        List <String> line = new ArrayList <> (Arrays.asList(html.split("\n")));

        for (int i = 0; i < line.size();i++) {
            String tag = getTag(line.get(i));
            if (tag != null) {
                if (isOpeningTag(tag)) {
                    tagStack.push(tag);
                } else if (isClosingTag(tag)) {
                    if (!tagStack.isEmpty() && tagsMatch(tagStack.peek(), tag)) {
                        tagStack.pop();
                    } else {
                        System.err.println("malformed HTML");
                        break;
                    }
                }
                if (tagStack.size() > deepestLevel) {
                    deepestLevel = tagStack.size();
                    deepestHtml = line.get(i+1);
                }
            }
        }
        System.out.println(deepestHtml);
    }

    private static String getTag(String line) {
        String tag = null;
        int start = line.indexOf('<');
        int end = line.indexOf('>');
        if (start >= 0 && end >= 0) {
            tag = line.substring(start, end + 1);
        }
        return tag;
    }

    private static boolean isOpeningTag(String tag) {
        return tag.startsWith("<") && !tag.startsWith("</");
    }

    private static boolean isClosingTag(String tag) {
        return tag.startsWith("</");
    }

    private static boolean tagsMatch(String openingTag, String closingTag) {
        return openingTag.substring(1).equals(closingTag.substring(2));
    }
}





