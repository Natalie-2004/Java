package factory.phone_camera;

public abstract class PhoneCameraApp {
    private ShareStartegy shareStartegy;

    public PhoneCameraApp(ShareStartegy shareStartegy) {
        this.shareStartegy = shareStartegy;
    }

    public void share() {
        shareStartegy.share();
    }

    public void take() {
        System.out.println(".()");
    }

    public void save() {
        System.out.println(".()");
    }

    public abstract void edit();



    public ShareStartegy getShareStartegy() {
        return shareStartegy;
    }



    public void setShareStartegy(ShareStartegy shareStartegy) {
        this.shareStartegy = shareStartegy;
    }
}
