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

package org.anvilpowered.catalyst.api.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.anvilpowered.catalyst.api.registry.ChatChannel;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ChannelService<TPlayer> {

  void switchChannel(UUID userUUID, String channelId);

  @Nullable ChatChannel getDefaultChannel();

  String getChannelIdForUser(UUID userUUID);

  @Nullable ChatChannel getChannelFromId(String channelId);

  @Nullable ChatChannel getChannelFromUUID(UUID userUUID);

  @Nullable String getDiscordChannelId(String channelId);

  int getChannelUserCount(String channelId);

  List<TPlayer> getUsersInChannel(String channelId);

  CompletableFuture<Boolean> moveUsersToChannel(String sourceChannel, String targetChannel);

}