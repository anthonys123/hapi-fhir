package ca.uhn.fhir.jpa.migrate.taskdef;

/*-
 * #%L
 * HAPI FHIR JPA Server - Migration
 * %%
 * Copyright (C) 2014 - 2019 University Health Network
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public abstract class BaseTableTask<T extends BaseTableTask> extends BaseTask {
	private String myTableName;

	public BaseTableTask(String theProductVersion, String theSchemaVersion) {
		super(theProductVersion, theSchemaVersion);
	}

	public String getTableName() {
		return myTableName;
	}

	public T setTableName(String theTableName) {
		Validate.notBlank(theTableName);
		myTableName = theTableName;
		return (T) this;
	}

	@Override
	public void validate() {
		Validate.notBlank(myTableName);
	}

	@Override
	public boolean equals(Object theO) {
		if (this == theO) return true;

		if (!(theO instanceof BaseTableTask)) return false;

		BaseTableTask<?> that = (BaseTableTask<?>) theO;

		return new EqualsBuilder()
			.append(myTableName, that.myTableName)
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(myTableName)
			.toHashCode();
	}
}
