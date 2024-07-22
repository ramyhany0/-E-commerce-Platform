public class ScrollBarDecorator extends UIComponentDecorator {
    public ScrollBarDecorator(UIComponent component) {
        super(component);
    }

    @Override
    public void render() {
        component.render();
        System.out.println("Adding scroll bar to component");
    }
}
