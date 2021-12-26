package ex2016.a01.t4.e1;

import java.util.Collection;

public class BuilderFactoryImpl implements BuilderFactory {

	@Override
	public <X> ListBuilder<X> makeBasicBuilder() {
		return new ListBuilderImpl<X>();
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithSize(int size) {
		// TODO Auto-generated method stub
		return new ListBuilderImpl<X>(size);
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithoutElements(Collection<X> out) {
		// TODO Auto-generated method stub
		return new ListBuilderImpl<X>(out);
	}

	@Override
	public <X> ListBuilder<X> makeBuilderWithoutElementsAndWithSize(Collection<X> out, int size) {
		return new ListBuilderImpl<X>(out, size);
	}

}
