/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.phuctrann.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 *
 * @author phuctrann
 */
public class Selenium2Go {

    public static void main(String[] args) {
        searchGoogle();
    }

    public static void searchGoogle() {
        // 1. Khai báo biến đại diện trỏ đến trình duyệt sẽ đc mở
        WebDriver myBrowser;// biến object thuộc bộ thư viện selenium

        //thằng này sẽ trỏ đến cái trình duyệt khi đc new
        // mỗi lần new là 1 trình duyệt đc mở ra, 1 vùng đc cấp
        // 1 object Trình duyệt đc new trong HEAP
        // 2. Khai báo người em song sinh, gã điều khiển trình duyệt
        //    nó luôn đc phát hành song song với phiên bản trình duyệt đời thực mà bá tánh xài
        //    tương thích version với trình duyệt đang xài !important BẮT BUỘC
        //    WebDriver là tên gọi của người anh em song sinh, là file .exe/ .dll
        String driverPath = "msedgedriver.exe";

        // 3. new Trình duyệt (mở trình duyệt) gắn kết với người em song sinh
        System.setProperty("webdriver.edge.driver", driverPath);

        // --> Báo với máy ảo Java rằng, có 1 thằng .exe muốn tham gia vào danh sách class mà JVM quản lí
        // .exe .dll xả 1 đống class điều khiển trình duyệt vào trong JVM lúc run-time
        // và gọi nhóm class này là webdriver.edge.driver -> Hằng số quy ước sẵn rồi
        // code selenium qua class WebDriver, Chrome Driver sẽ xài ở dưới đây
        // biết cách chơi với các class của .exe vừa rồi vì chúng đang cùng ở trong máy ảo.
        myBrowser = new EdgeDriver();

        // 4. Viết code dùng Selenium để nói chuyện với người song sinh (driver)
        //    - Driver biết cách nch với Trình duyệt real đang đc new !!!
        //    - Trình duyệt sẵn sàng thông qua người em đưa hết data (trang web trong RAM)
        //      cho mình dưới dạng cây DOM - Document Object Model
        //      trang HTML trả về trong RAM của trình duyệt đc xem là 1 cây các object
        //      Node/tag đc xem là 1 object thuộc nhóm WebElement
        myBrowser.get("http://google.com"); //search web của trình duyệt vừa new
        myBrowser.manage().window().maximize();
        
        
        // ta sẽ đi tìm các tag, và hành xử trên các thẻ

        //MEMORY LEAK
    }

    public static void searchGoogleV2() {
        WebDriver myBrowser;
        String driverPath = "msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", driverPath);

        EdgeOptions opt = new EdgeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang= vi"); 
        // vi: Vietnamese
        // en-GB: English
        // zh-cn: Chinese

        myBrowser = new EdgeDriver(opt);

        myBrowser.get("http://google.com"); //search web của trình duyệt vừa new
        myBrowser.manage().window().maximize();

    }
}
