package utils;

public enum HeaderMenuItem {
    HOME("//a[@href='/home']"),//"a[@text()='HOME'
    ABOUT("//a[@href='/about']"),
    CONTACTS("//a[@href='/contacts']"),
    ADD("//a[@href='/add']"),
    LOGIN("//a[@href='/login']"),
    SIGN_UP("//*[text()='Sign Out']");
    private  final String locator;

    HeaderMenuItem(String locator) {
        this.locator = locator;
    }
    public String getLocator(){
       return locator;
    }
}
