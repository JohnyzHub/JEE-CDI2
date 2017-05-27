package org.myjee.cdi.practice.BookStore.extension;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.InjectionException;
import javax.enterprise.inject.spi.AnnotatedField;
import javax.enterprise.inject.spi.AnnotatedType;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.InjectionTarget;
import javax.enterprise.inject.spi.ProcessInjectionTarget;

public class PropertyLoaderExtension implements Extension {
	private final Map<Field, Object> fieldValues = new HashMap<>(2);

	public <T> void performPropertyLoading(final @Observes ProcessInjectionTarget<T> processInjection) {
		AnnotatedType<T> annotatedType = processInjection.getAnnotatedType();

		if (!annotatedType.isAnnotationPresent(PropertyFile.class)) {
			return;
		}

		PropertyFile propertyFile = annotatedType.getAnnotation(PropertyFile.class);
		String fileName = propertyFile.value();
		InputStream inputStream = getClass().getResourceAsStream("/" + fileName);
		Properties properties = new Properties();

		try {
			properties.load(inputStream);
			assignPropertiesToField(annotatedType.getFields(), properties);
		} catch (Exception e) {
			e.printStackTrace();
		}

		final InjectionTarget<T> injectionTarget = processInjection.getInjectionTarget();
		InjectionTarget<T> wrapped = new InjectionTarget<T>() {
			@Override
			public void inject(T instance, CreationalContext<T> ctx) {
				injectionTarget.inject(instance, ctx);
				for (Map.Entry<Field, Object> property : fieldValues.entrySet()) {
					try {
						Field key = property.getKey();
						key.setAccessible(true);
						Class<?> baseType = key.getType();
						String value = property.getValue().toString();
						if (baseType == String.class) {
							key.set(instance, value);
						} else if (baseType == Float.class) {
							key.set(instance, Float.valueOf(value));
						} else if (baseType == Integer.class) {
							key.set(baseType, Integer.valueOf(value));
						} else {
							String msg = "Type " + baseType + " of field " + key.getName() + " not recognized.";
							System.out.println("Error: " + msg);
							processInjection.addDefinitionError(new InjectionException(msg));
						}
					} catch (Exception e) {
						processInjection.addDefinitionError(new InjectionException(e));
					}
				}
			}

			@Override
			public T produce(CreationalContext<T> ctx) {
				// TODO Auto-generated method stub
				return injectionTarget.produce(ctx);
			}

			@Override
			public void dispose(T instance) {
				// TODO Auto-generated method stub
				injectionTarget.dispose(instance);
			}

			@Override
			public Set<InjectionPoint> getInjectionPoints() {
				// TODO Auto-generated method stub
				return injectionTarget.getInjectionPoints();
			}

			@Override
			public void postConstruct(T instance) {
				// TODO Auto-generated method stub
				injectionTarget.postConstruct(instance);

			}

			@Override
			public void preDestroy(T instance) {
				// TODO Auto-generated method stub
				injectionTarget.dispose(instance);

			}
		};

		processInjection.setInjectionTarget(wrapped);

	}

	private <T> void assignPropertiesToField(Set<AnnotatedField<? super T>> fields, Properties properties)
			throws Exception {
		for (AnnotatedField<? super T> field : fields) {
			if (field.isAnnotationPresent(Property.class)) {
				Field memberField = field.getJavaMember();
				Property property = field.getAnnotation(Property.class);
				Object value = properties.get(property.value());
				fieldValues.put(memberField, value);
			}
		}
	}
}