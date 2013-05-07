package ch.uzh.ifi.seal.contextmodels.ruleengine.impl;

import ch.uzh.ifi.seal.contextmodels.astanalyzer.ClassAnalyzer;
import ch.uzh.ifi.seal.contextmodels.eventmodel.abstractevents.Event;
import ch.uzh.ifi.seal.contextmodels.model.ContextModel;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaClass;
import ch.uzh.ifi.seal.contextmodels.model.javaelements.JavaElement;
import ch.uzh.ifi.seal.contextmodels.ruleengine.RulesDsl;
import ch.uzh.ifi.seal.contextmodels.util.Logger;

public class RulesDslImpl implements RulesDsl {

	@Override
	public TimeUnit every(int number) {
		return new TimeUnitImpl(number);
	}

	@Override
	public JavaElementAction onEvent(Class<? extends Event> event) {
		return new JavaElementActionImpl(new EventExecutionContext(event));
	}
	
	class TimeUnitImpl implements TimeUnit {

		private int number;
		
		public TimeUnitImpl(int number) {
			this.number = number;
		}
		
		@Override
		public JavaElementSelector miliseconds() {
			return new JavaElementSelectorImpl(new TimerExecutionContext(number));
		}

		@Override
		public JavaElementSelector seconds() {
			return new JavaElementSelectorImpl(new TimerExecutionContext(number * 1000));
		}

		@Override
		public JavaElementSelector minutes() {
			return new JavaElementSelectorImpl(new TimerExecutionContext(number * 60000));
		}
		
	}
	
	class JavaElementSelectorImpl implements JavaElementSelector {

		private JavaElementExecutionContext context;
		
		public JavaElementSelectorImpl(JavaElementExecutionContext context) {
			this.context = context;
		}
		
		@Override
		public JavaElementAction withJavaElement(JavaElement element) {
			context.addAffectedJavaElement(element);
			return new JavaElementActionImpl(context);
		}

		@Override
		public JavaElementAction forAllJavaElements() {
			context.setAffectsAllElements();
			return new JavaElementActionImpl(context);
		}		
	}
	
	class JavaElementActionImpl implements JavaElementAction {

		private ExecutionContext context;
		
		public JavaElementActionImpl(ExecutionContext context) {
			this.context = context;
		}
		
		@Override
		public void increaseRelevancyBy(final double number) {
			context.execute(new Task() {
				@Override
				public void run(JavaElement element) {
					ContextModel.get().changeRelevance(element, number);
				}
			});
		}
		
		@Override
		public void setActive() {
			context.execute(new Task() {
				@Override
				public void run(JavaElement element) {
					ContextModel.get().setActiveElement(element);
				}
			});
		}
		
		@Override
		public void findStructuralDependencies() {
			context.execute(new Task() {
				@Override
				public void run(JavaElement element) {
					if(element instanceof JavaClass) {
						new ClassAnalyzer((JavaClass)element).findRelatedElements();
					}
				}
			});
		}

		@Override
		public void log(final String logMessage) {
			context.execute(new Task() {
				@Override
				public void run(JavaElement element) {
					final String message = "JavaElement: " + element + ", Message: " + logMessage;
					Logger.info(message);
				}
			});
		}

		@Override
		public JavaElementAction forAllJavaElements() {
			context.setAffectsAllElements();
			return new JavaElementActionImpl(context);
		}

		
		
	}
	
}
