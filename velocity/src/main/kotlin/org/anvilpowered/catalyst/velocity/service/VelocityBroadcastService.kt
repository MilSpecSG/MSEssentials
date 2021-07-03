/*
 *   Catalyst - AnvilPowered
 *   Copyright (C) 2021
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see https://www.gnu.org/licenses/.
 */

package org.anvilpowered.catalyst.velocity.service

import com.google.inject.Inject
import com.velocitypowered.api.proxy.ProxyServer
import net.kyori.adventure.identity.Identity
import net.kyori.adventure.text.TextComponent
import org.anvilpowered.catalyst.api.service.BroadcastService

class VelocityBroadcastService @Inject constructor(
  private val proxyServer: ProxyServer
) : BroadcastService<TextComponent> {
  override fun broadcast(message: TextComponent) {
    if (message.toString().isEmpty()) {
      return
    }
    proxyServer.allPlayers.forEach { it.sendMessage(Identity.nil(), message) }
  }
}