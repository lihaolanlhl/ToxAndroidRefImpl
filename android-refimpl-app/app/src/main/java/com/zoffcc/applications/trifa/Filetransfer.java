/**
 * [TRIfA], Java part of Tox Reference Implementation for Android
 * Copyright (C) 2017 Zoff <zoff@zoff.cc>
 * <p>
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * version 2 as published by the Free Software Foundation.
 * <p>
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the
 * Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
 * Boston, MA  02110-1301, USA.
 */

package com.zoffcc.applications.trifa;

import com.github.gfx.android.orma.annotation.Column;
import com.github.gfx.android.orma.annotation.PrimaryKey;
import com.github.gfx.android.orma.annotation.Table;

import static com.zoffcc.applications.trifa.TRIFAGlobals.TRIFA_FT_DIRECTION.TRIFA_FT_DIRECTION_INCOMING;
import static com.zoffcc.applications.trifa.ToxVars.TOX_FILE_CONTROL.TOX_FILE_CONTROL_CANCEL;
import static com.zoffcc.applications.trifa.ToxVars.TOX_FILE_KIND.TOX_FILE_KIND_DATA;

@Table
public class Filetransfer
{
    @PrimaryKey(autoincrement = true, auto = true)
    long id;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    String tox_public_key_string = "";

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    int direction = TRIFA_FT_DIRECTION_INCOMING.value;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    long file_number = -1;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    int kind = TOX_FILE_KIND_DATA.value;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    int state = TOX_FILE_CONTROL_CANCEL.value;

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    String path_name = "";

    @Column(indexed = true, helpers = Column.Helpers.ALL)
    String file_name = "";

    @Column
    boolean fos_open = false;

    @Column
    long filesize = -1;

    @Column
    long current_position = 0;

    static Filetransfer deep_copy(Filetransfer in)
    {
        Filetransfer out = new Filetransfer();
        out.tox_public_key_string = in.tox_public_key_string;
        out.file_number = in.file_number;
        out.kind = in.kind;
        out.state = in.state;
        out.path_name = in.path_name;
        out.file_name = in.file_name;
        out.fos_open = in.fos_open;
        out.filesize = in.filesize;
        out.current_position = in.current_position;
        return out;
    }

    @Override
    public String toString()
    {
        return "id=" + id + ", kind=" + kind + ", path_name=" + path_name + ", file_name=" + file_name + ", filesize=" + filesize + ", current_position=" + current_position;
    }
}