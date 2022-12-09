import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;
import java.awt.*;

class MyDefaultMetalTheme extends DefaultMetalTheme {
    /*public ColorUIResource getSystemTextColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getControlTextColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getInactiveControlTextColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getInactiveSystemTextColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getUserTextColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getTextHighlightColor(){
        return new ColorUIResource(Color.white);
    }
    public ColorUIResource getHighlightedTextColor(){
        return new ColorUIResource(Color.white);
    }*/
    public ColorUIResource getWindowTitleInactiveBackground() {
        return new ColorUIResource(java.awt.Color.black);
    }

    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(java.awt.Color.black);
    }

    public ColorUIResource getPrimaryControlHighlight() {
        return new ColorUIResource(Color.black);
    }

    public ColorUIResource getPrimaryControlDarkShadow() {
        return new ColorUIResource(Color.black);
    }

    public ColorUIResource getPrimaryControl() {
        return new ColorUIResource(Color.red);
    }

    public ColorUIResource getControlHighlight() {
        return new ColorUIResource(Color.white);
    }

    public ColorUIResource getControlDarkShadow() {
        return new ColorUIResource(Color.white);
    }

    public ColorUIResource getControl() {
        return new ColorUIResource(Color.white);
    }
}