package com.example.vectorov.eduproject_22092016;

import android.location.Location;
import android.net.Uri;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by vectorov on 22.09.2016.
 */
public class Config {
    final static public String LINK_STORE = "http://aschoolapi.appspot.com/";
    // strings for request to StoreTest
    public static int _idStore;
    public static String _nameStore;
    public static String _addressStore;
    public static String _phoneStore;
    public static Location _locationStore;
    // strings for request to Instrument
    public static int _idInstrument;
    public static String _brandInstrument;
    public static String _modelInstrument;
    public static String _imageUrlInstrument;
    public static String _typeInstrument;
    public static double _priceInstrument;
    public static int _quantityInstrument;
    // strings for Location
    public static int _latitudeLocation;
    public static int _longitudeLocation;


    public static final int REPLACE = 0;
    public static final int DIALOG_REPLACE = 1;
    public final static String LOG_TAG = "myLogs";
    public static final int DIALOG_ALERT = 2;
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

    public static Uri STORES_URI = Uri.parse("content://com.example.vectorov.testcontentprovider/stores");
    public static Uri TOOLS_URI = Uri.parse("content://com.example.vectorov.testcontentprovider/tools");


    private static final int[] STORE_ID = {
            1, 1, 2, 2, 3, 3,
            4, 4, 5, 5, 6, 6,
            7, 7, 8, 8, 9, 9,
            10, 10, 11, 11, 12, 12, 13, 13, 14, 14, 15, 15 };
    private static final String[] StoreNames = {
            "Магазин 1","Магазин 2","Магазин 3","Магазин 4",
            "Магазин 5","Магазин 6","Магазин 7",
            "Магазин 8","Магазин 9","Магазин 10",
            "Магазин 11","Магазин 12", "Магазин 13","Магазин 14","Магазин 15"};

    private static final String[] StoreTel = {
            "380(67)454-69-10",
            "380(67)291-87-04",
            "380(67)011-16-71",
            "380(67)159-34-26",
            "380(67)806-72-64",
            "380(67)662-36-70",
            "380(67)928-69-97",
            "380(67)564-98-18",
            "380(67)144-30-98",
            "380(67)510-18-08",
            "380(67)374-27-13",
            "380(67)881-79-93",
            "380(67)484-57-32",
            "380(67)424-33-31",
            "380(67)058-77-29"};

    private static final String[] StoreEmail = {"sjef@usa.net",
            "diaqui@lycos.com",
            "viasischja@chat.ru",
            "vjidyquos@mnogo.ru",
            "myemyn@pop3.ru",
            "gaepyuvja@visto.com",
            "rooryaz@usa.net",
            "syaji@smtp.ru",
            "luzjaf@lycos.com",
            "noupo@hob.ru",
            "mialjo@adelite.com",
            "qujac@hotbox.com",
            "xoqui@hotbox.ru",
            "loomoubysch@mnogo.ru",
            "thyam@max.ru"};
    private static final String[] BRAND = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов", "J R R Tolkien","J R R Tolkien","J R R Tolkien"};

    private static final String[] MODEL = {
            "Клей полимерный Elite Drakon 0.2 л",
            "Клей Жидкое стекло Мальва 1.3 кг",
            "Клей Момент Монтаж Экспресс 125 г",
            "Клей для декора Lacrysil белый 200 г",
            "Клей для пенополистирола Зебра 280 мл",
            "Клей монтажный Lacrysil Круче 1000 Гвоздей белый 200 г",
            "Клей-герметик 2в1 Lacrysil Крепче гвоздей 150 г",
            "Клей монтажный Lacrysil Круче 1000 Гвоздей прозрачный 150 г",
            "Клей монтажный Lacrysil Сумасшедшая липучка 200 г",
            "Клей для пенополистирола Примус 280 мл",
            "Клей Декор Acrylin-5 400 гр ",
            "Клей монтажный Lacrysil Круче 1000 Гвоздей 280 мл",
            "Клей полимерный Elite Drakon 0.4 л",
            "Клей для декора Lakrysil Крепче гвоздей 280 мл белый",
            "Клей акриловый универсальный Lacrysil Круче гвоздей прозрачный 280 мл",
            "Клей универсальный Vinyl&Plastic Акрилин-3 400 гр",
            "Клей Сумасшедшая липучка универсальный 280 мл",
            "Клей-герметик Lakrysil Крепче гвоздей прозрачный 280 мл ",
            "Клей Жидкое стекло Мальва 2.5 кг",
            "Клей Момент Монтаж Экспресс 250 г",
            "Клей универсальный Lakrysil Крепче гвоздей 280 мл",
            "Клей монтажный Lakrysil Крепче гвоздей 280 мл",
            "Клей Прочный Контакт 400 гр",
            "Клей монтажный Penosil Super Fix 310 мл",
            "Эдем Версаль 590-20 0.53x10.05 м",
            "Славянские обои Gracia В64.4 Ансамбль 2 7057-01 0.53x10.05 м",
            "Славянские обои Gracia В64.4 Ансамбль 2 7057-05 0.53x10.05 м",
            "Ланита Рейн декор ВК 4-0807 0.53х10.05 м",
            "Ланита Рейн декор ВК 5-0807 0.53х10.05 м",
            "Славянские обои Comfort В58.4 Адлер 326-07 0.53х10.05 м"};
    private static final String[] IMAGEURL = {
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Михаил Булгаков","Михаил Булгаков","Эрнест Хемингуей","Эрнест Хемингуей",
            "Энтони Берджес","Джорж Оруэлл","Михаил Шолохов",
            "Джорж Мартин","Братья Стругацкие","Братья Стругацкие",
            "Антон Чехов","Антон Чехов", "J R R Tolkien","J R R Tolkien","J R R Tolkien"};

    private static final String[] TYPE = {
            "Клей","Клей","Клей","Клей","Клей",
            "Клей","Клей","Клей","Клей","Клей",
            "Клей","Клей","Клей","Клей","Клей",
            "Клей","Клей","Клей","Клей","Клей",
            "Клей","Клей","Клей","Клей","Клей",
            "Обои","Обои","Обои","Обои","Обои"};
    private static final double [] PRICE = {
            19.98,25.35,25.49,25.95,27.60,27.95,27.95,28.95,28.95,30.72,
            32.65,35.22,36.00,38.95,39.54,41.95,44.95,44.95,48.00,48.90,
            48.95,53.22,54.30,55.00,48.96,64.90,64.90,69.00,69.00,114.42};

    private static final int[] QUANTITY = {
            20, 21, 22, 23, 24,
            20, 21, 22, 23, 24,
            25, 26, 27, 28, 29, 30,
            25, 26, 27, 28, 29, 30,
            31, 32,  33, 34, 35, 2, 1, 5};

    public static ArrayList getToolsData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<MODEL.length; i++){
            arrayList.add(new ToolsTest()
                    .setBrand(BRAND[i])
                    .setModel(MODEL[i])
                    .setImageUrl(IMAGEURL[i])
                    .setType(TYPE[i])
                    .setPrice(PRICE[i])
                    .setQuantity(QUANTITY[i])
                    .setStoreId(STORE_ID[i]));
        }
        return arrayList;
    }

    public static ArrayList getStoreData(){
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i<StoreNames.length; i++){
            arrayList.add(new StoreTest()
                    .setName(StoreNames[i])
                    .setPhone(StoreTel[i])
                    .setAddress(StoreEmail[i]));
        }
        return arrayList;
    }
}
