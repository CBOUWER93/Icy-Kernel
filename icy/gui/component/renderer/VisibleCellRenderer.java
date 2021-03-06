/**
 * 
 */
package icy.gui.component.renderer;

import icy.resource.ResourceUtil;
import icy.resource.icon.IcyIcon;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.TableCellRenderer;
import javax.swing.tree.TreeCellRenderer;

/**
 * @author Stephane
 */
public class VisibleCellRenderer extends JLabel implements TableCellRenderer, TreeCellRenderer
{
    /**
     * 
     */
    private static final long serialVersionUID = -5511881886845059452L;

    int iconSize;

    public VisibleCellRenderer(int iconSize)
    {
        super();

        this.iconSize = iconSize;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column)
    {
        final boolean b = ((Boolean) value).booleanValue();

        if (b)
            setIcon(new IcyIcon(ResourceUtil.ICON_VISIBLE, iconSize));
        else
            setIcon(new IcyIcon(ResourceUtil.ICON_NOT_VISIBLE, iconSize));

        return this;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
            boolean leaf, int row, boolean hasFocus)
    {
        final boolean b = ((Boolean) value).booleanValue();

        if (b)
            setIcon(new IcyIcon(ResourceUtil.ICON_VISIBLE, iconSize));
        else
            setIcon(new IcyIcon(ResourceUtil.ICON_NOT_VISIBLE, iconSize));

        return this;
    }

    /**
     * Overridden for performance reasons.
     */
    @Override
    public void invalidate()
    {
    }

    /**
     * Overridden for performance reasons.
     */
    @Override
    public void validate()
    {
    }

    /**
     * Overridden for performance reasons.
     */
    @Override
    public void revalidate()
    {
    }

    /**
     * Overridden for performance reasons.
     */
    @Override
    public void repaint(long tm, int x, int y, int width, int height)
    {
    }

    /**
     * Overridden for performance reasons.
     */
    @Override
    public void repaint(Rectangle r)
    {
    }

    /**
     * Overridden for performance reasons.
     * 
     * @since 1.5
     */
    @Override
    public void repaint()
    {
    }
}
