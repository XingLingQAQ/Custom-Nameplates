/*
 *  Copyright (C) <2024> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customnameplates.bukkit.requirement.builtin;

import net.momirealms.customnameplates.api.CNPlayer;
import net.momirealms.customnameplates.api.requirement.AbstractRequirement;
import org.bukkit.entity.Player;

import java.util.*;

public class EnvironmentRequirement extends AbstractRequirement {

	private final Set<String> environments;

	public EnvironmentRequirement(int refreshInterval, List<String> list) {
		super(refreshInterval);
		this.environments = new HashSet<>(list);
	}

	@Override
	public boolean isSatisfied(CNPlayer p1, CNPlayer p2) {
		var name = ((Player) p1.player()).getWorld().getEnvironment().name().toLowerCase(Locale.ENGLISH);
		return environments.contains(name);
	}

	@Override
	public String type() {
		return "environment";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EnvironmentRequirement that = (EnvironmentRequirement) o;
		return environments.equals(that.environments);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(environments);
	}
}