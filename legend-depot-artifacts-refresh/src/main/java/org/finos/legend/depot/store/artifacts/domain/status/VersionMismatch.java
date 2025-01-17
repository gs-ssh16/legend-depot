//  Copyright 2021 Goldman Sachs
//
//  Licensed under the Apache License, Version 2.0 (the "License");
//  you may not use this file except in compliance with the License.
//  You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//  Unless required by applicable law or agreed to in writing, software
//  distributed under the License is distributed on an "AS IS" BASIS,
//  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  See the License for the specific language governing permissions and
//  limitations under the License.
//

package org.finos.legend.depot.store.artifacts.domain.status;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VersionMismatch
{
    @JsonProperty
    public String projectId;
    @JsonProperty
    public String groupId;
    @JsonProperty
    public String artifactId;
    @JsonProperty
    public List<String> versionsNotInCache = new ArrayList<>();
    @JsonProperty
    public List<String> versionsNotInRepo = new ArrayList<>();


    public VersionMismatch(String projectId, String groupId, String artifactId, List<String> versionsNotInCache, List<String> versionsNotInRepo)
    {
        this.projectId = projectId;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.versionsNotInCache.addAll(versionsNotInCache);
        this.versionsNotInRepo.addAll(versionsNotInRepo);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        VersionMismatch that = (VersionMismatch) o;
        return Objects.equals(projectId, that.projectId) && Objects.equals(groupId, that.groupId) && Objects.equals(artifactId, that.artifactId);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(projectId, groupId, artifactId);
    }
}