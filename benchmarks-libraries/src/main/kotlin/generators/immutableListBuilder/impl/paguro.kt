/*
 * Copyright 2016-2019 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package generators.immutableListBuilder.impl

object PaguroListBuilderImplementation: ListBuilderImplementation {
    override val packageName: String
            = "paguro.builder"

    override fun type(): String
            = "org.organicdesign.fp.collections.RrbTree.MutableRrbt<$listBuilderElementType>"
    override fun empty(): String
            = "org.organicdesign.fp.collections.RrbTree.emptyMutable<$listBuilderElementType>()"

    override fun getOperation(builder: String, index: String): String
            = "$builder.get($index)"
    override fun setOperation(builder: String, index: String, newValue: String): String
            = "$builder.replace($index, $newValue)"
    override fun addOperation(builder: String, element: String): String
            = "$builder.append($element)"
    override fun removeLastOperation(builder: String): String
            = "$builder.without($builder.size - 1)"

    override val isIterable: Boolean
            = true

    override fun builderOperation(immutable: String): String
            = "$immutable.mutable()"

    override fun immutableEmpty(): String
            = "org.organicdesign.fp.collections.RrbTree.empty<$listBuilderElementType>()"
    override fun immutableAddOperation(immutable: String, element: String): String
            = "$immutable.append($element)"
}