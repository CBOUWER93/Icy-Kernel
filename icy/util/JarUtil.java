/*
 * Copyright 2010, 2011 Institut Pasteur.
 * 
 * This file is part of ICY.
 * 
 * ICY is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * ICY is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with ICY. If not, see <http://www.gnu.org/licenses/>.
 */
package icy.util;

import icy.network.NetworkUtil;
import icy.network.URLUtil;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * JAR utilities class
 * 
 * @author Stephane
 */
public class JarUtil
{
    /**
     * Return true if specified URL is a JAR url
     */
    public static boolean isJarURL(String path)
    {
        return (path != null) && path.toUpperCase().startsWith("JAR:") && URLUtil.isURL(path.substring(4));
    }

    /**
     * Return a JAR URL from the specified path
     */
    public static URL getJarURL(String path)
    {
        if (path == null)
            return null;

        if (path.toUpperCase().startsWith("JAR:"))
            return URLUtil.getURL(path.substring(4));

        return URLUtil.getURL("jar:" + URLUtil.getURL(path) + "!/");
    }

    /**
     * Return a JAR URL from the specified JAR path and JAR entry
     */
    public static URL getJarURL(String jarPath, JarEntry entry)
    {
        return URLUtil.getURL(getJarURL(jarPath) + entry.getName());
    }

    /**
     * Return a JAR File from the specified path
     */
    public static JarFile getJarFile(String path)
    {
        try
        {
            if (isJarURL(path))
                return ((JarURLConnection) NetworkUtil.openConnection(getJarURL(path), false, true)).getJarFile();

            return new JarFile(path);
        }
        catch (IOException e)
        {
            return null;
        }
    }

    /**
     * Find a class entry in the specified JAR file
     */
    public static JarEntry getJarClassEntry(JarFile file, String className)
    {
        return file.getJarEntry(className.replace('.', '/') + ".class");
    }

    /**
     * Find the specified entry in the specified JAR file
     */
    public static JarEntry getJarEntry(JarFile file, String entryName)
    {
        return file.getJarEntry(entryName);
    }

}
