public abstract class UIComponentDecorator implements UIComponent {
    protected UIComponent component;

    public UIComponentDecorator(UIComponent component) {
        this.component = component;
    }

    public void render() {
        component.render();
    }
}
