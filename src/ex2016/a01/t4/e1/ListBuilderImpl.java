package ex2016.a01.t4.e1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ListBuilderImpl<X> implements ListBuilder<X> {
	
	private final List<X> list;
	private Collection<X> bannedElements;
	private boolean buildDone;
	private final int size;
	
	public ListBuilderImpl() {
		this(Collections.unmodifiableCollection(new ArrayList<>()), 0);
	}
	
	public ListBuilderImpl(final int size) {
		this(Collections.unmodifiableCollection(new ArrayList<>()), size);
	}
	
	public ListBuilderImpl(final Collection<X> banned) {
		this(banned, 0);
	}
	
	public ListBuilderImpl(final Collection<X> banned, final int size) {
		this.buildDone = false;
		this.size = size;
		this.list = new ArrayList<>(size);
		this.bannedElements = banned;
	}

	private boolean isValidElement(final X x) {
		return !this.bannedElements.contains(x);
	}
	
	@Override
	public void add(X x) {
		if (this.buildDone || Objects.isNull(x)) {
			throw new IllegalStateException();
		}
		if (!isValidElement(x)) {
			throw new IllegalArgumentException();
		}
		this.list.add(x);
	}
	
	private boolean listIsFull() {
		if (this.size != 0) {
			return this.size == this.list.size();
		}
		return true;
	}

	@Override
	public List<X> build() {
		if (this.buildDone || !listIsFull()) {
			throw new IllegalStateException();
		}
		this.buildDone = true;
		return Collections.unmodifiableList(list);
	}

}
