import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author)
    {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String toString()
    {
        return title + " - " + content + ": " + author;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] token = scanner.nextLine().split(",");
            String title = token[0];
            String content = token[1];
            String author = token[2];

            Article article = new Article(title, content, author);

            }

        String typeCommand = scanner.nextLine();
        switch (typeCommand)
        {
            case "title":
                articles.sort(Comparator.comparing(Article::getTitle));
                break;
            case "content":
                articles.sort(Comparator.comparing(Article::getContent));
                break;
            case "author":
                articles.sort(Comparator.comparing(Article::getAuthor));
                break;

        }
        for (Article article:articles) {
            System.out.println(article.toString());
        }
    }
}
