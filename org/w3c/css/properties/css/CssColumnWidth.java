// $Id$
// From Sijtsche de Jong (sy.de.jong@let.rug.nl)
// Rewriten 2010 Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT 1995-2010  World Wide Web Consortium (MIT, ERCIM and Keio)
// Please first read the full copyright statement at
// http://www.w3.org/Consortium/Legal/copyright-software-19980720

package org.w3c.css.properties.css;

import org.w3c.css.parser.CssStyle;
import org.w3c.css.properties.css3.Css3Style;
import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssExpression;

/**
 * @since CSS3
 */

public class CssColumnWidth extends CssProperty {

    private static final String propertyName = "column-width";

    /**
     * Create a new CssColumnWidth
     */
    public CssColumnWidth() {
    }

    /**
     * Create a new CssColumnWidth
     *
     * @param expression The expression for this property
     * @throws InvalidParamException Incorrect value
     */
    public CssColumnWidth(ApplContext ac, CssExpression expression,
                          boolean check) throws InvalidParamException {


                throw new InvalidParamException("unrecognize", ac);
    }

    public CssColumnWidth(ApplContext ac, CssExpression expression)
            throws InvalidParamException {
        this(ac, expression, false);
    }

    /**
     * Add this property to the CssStyle
     *
     * @param style The CssStyle
     */
    public void addToStyle(ApplContext ac, CssStyle style) {
        if (((Css3Style) style).cssColumnWidth != null)
            style.addRedefinitionWarning(ac, this);
        ((Css3Style) style).cssColumnWidth = this;
    }

    /**
     * Get this property in the style.
     *
     * @param style   The style where the property is
     * @param resolve if true, resolve the style to find this property
     */
    public CssProperty getPropertyInStyle(CssStyle style, boolean resolve) {
        if (resolve) {
            return ((Css3Style) style).getColumnWidth();
        } else {
            return ((Css3Style) style).cssColumnWidth;
        }
    }

    /**
     * Compares two properties for equality.
     *
     * @param property The other property.
     */
    public boolean equals(CssProperty property) {
        return false;
    }

    /**
     * Returns the name of this property
     */
    public final String getPropertyName() {
        return propertyName;
    }

    /**
     * Returns the value of this property
     */
    public Object get() {
        return null;
    }

    /**
     * Returns true if this property is "softly" inherited
     */
    public boolean isSoftlyInherited() {
        return false;
    }

    /**
     * Returns a string representation of the object
     */
    public String toString() {
        return null;
    }

    /**
     * Is the value of this property a default value
     * It is used by all macro for the function <code>print</code>
     */
    public boolean isDefault() {
        return false;
    }

}
