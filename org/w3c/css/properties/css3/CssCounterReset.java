// $Id$
// Author: Yves Lafon <ylafon@w3.org>
//
// (c) COPYRIGHT MIT, ERCIM and Keio University, 2012.
// Please first read the full copyright statement in file COPYRIGHT.html
package org.w3c.css.properties.css3;

import org.w3c.css.util.ApplContext;
import org.w3c.css.util.InvalidParamException;
import org.w3c.css.values.CssCheckableValue;
import org.w3c.css.values.CssExpression;
import org.w3c.css.values.CssTypes;
import org.w3c.css.values.CssValue;
import org.w3c.css.values.CssValueList;

import java.util.ArrayList;

import static org.w3c.css.values.CssOperator.SPACE;

/**
 * @spec http://www.w3.org/TR/2003/WD-css3-content-20030514/#counter-reset
 */
public class CssCounterReset extends org.w3c.css.properties.css.CssCounterReset {

	/**
	 * Create a new CssCounterReset
	 */
	public CssCounterReset() {
		value = initial;
	}

	/**
	 * Creates a new CssCounterReset
	 *
	 * @param expression The expression for this property
	 * @throws org.w3c.css.util.InvalidParamException
	 *          Expressions are incorrect
	 */
	public CssCounterReset(ApplContext ac, CssExpression expression, boolean check)
			throws InvalidParamException {
		setByUser();

		CssValue val;
		char op;
		boolean intallowed = false;
		ArrayList<CssValue> v = new ArrayList<CssValue>();

		while (!expression.end()) {
			val = expression.getValue();
			op = expression.getOperator();
			switch (val.getType()) {
				case CssTypes.CSS_IDENT:
					if (inherit.equals(val)) {
						value = inherit;
						if (expression.getCount() > 1) {
							throw new InvalidParamException("value", val,
									getPropertyName(), ac);
						}
						break;
					}
					if (none.equals(val)) {
						value = none;
						if (expression.getCount() > 1) {
							throw new InvalidParamException("value", val,
									getPropertyName(), ac);
						}
						break;
					}
					// initial is reserved keyword
					if (initial.equals(val)) {
						throw new InvalidParamException("value", val,
								getPropertyName(), ac);
					}
					v.add(val);
					intallowed = true;
					break;
				case CssTypes.CSS_NUMBER:
					if (intallowed) {
						// we allow int only after an ident
						intallowed = false;
						CssCheckableValue n = val.getCheckableValue();
						n.checkInteger(ac, this);
						v.add(val);
						break;
					}
					// if int wasn't allowed, let it fail
				default:
					throw new InvalidParamException("value", val,
							getPropertyName(), ac);
			}
			if (op != SPACE) {
				throw new InvalidParamException("operator",
						((new Character(op)).toString()), ac);
			}
			expression.next();
		}
		// check it's not inherit or none
		if (v.size() > 0) {
			value = (v.size() == 1) ? v.get(0) : new CssValueList(v);
		}
	}

	public CssCounterReset(ApplContext ac, CssExpression expression)
			throws InvalidParamException {
		this(ac, expression, false);
	}

}

