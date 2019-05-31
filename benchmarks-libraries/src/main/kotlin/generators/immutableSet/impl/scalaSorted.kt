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

package generators.immutableSet.impl

object ScalaSortedSetImplementation: SetImplementation {
    override val packageName: String
            = "scalaSorted"

    override fun type(): String
            = "scala.collection.immutable.TreeSet<$setElementType>"
    override fun empty(): String
            = "scala.collection.immutable.TreeSet(scala.math.Ordering.comparatorToOrdering(Comparator.naturalOrder<$setElementType>()))"

    override fun addOperation(set: String, element: String): String
            = "$set.incl($element)"
    override fun removeOperation(set: String, element: String): String
            = "$set.excl($element)"
}