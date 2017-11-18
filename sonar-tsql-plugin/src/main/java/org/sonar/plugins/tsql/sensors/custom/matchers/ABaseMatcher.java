package org.sonar.plugins.tsql.sensors.custom.matchers;

import org.sonar.plugins.tsql.checks.custom.RuleImplementation;
import org.sonar.plugins.tsql.sensors.custom.nodes.IParsedNode;

public abstract class ABaseMatcher implements IMatcher {

	protected abstract boolean innerMatch(RuleImplementation rule, IParsedNode item);

	protected abstract boolean shouldApply(RuleImplementation rule, IParsedNode item);

	@Override
	public boolean match(RuleImplementation rule, IParsedNode item) {
		if (shouldApply(rule, item)) {
			return innerMatch(rule, item);
		}
		return true;
	}

}
