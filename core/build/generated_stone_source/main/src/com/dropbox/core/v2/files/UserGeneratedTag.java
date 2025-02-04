/* DO NOT EDIT */
/* This file was generated from file_tagging.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneDeserializerLogger;
import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class UserGeneratedTag {
    // struct files.UserGeneratedTag (file_tagging.stone)

    protected final String tagText;

    /**
     *
     * @param tagText  Must have length of at least 1, have length of at most
     *     32, match pattern "{@code [\\w]+}", and not be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public UserGeneratedTag(String tagText) {
        if (tagText == null) {
            throw new IllegalArgumentException("Required value for 'tagText' is null");
        }
        if (tagText.length() < 1) {
            throw new IllegalArgumentException("String 'tagText' is shorter than 1");
        }
        if (tagText.length() > 32) {
            throw new IllegalArgumentException("String 'tagText' is longer than 32");
        }
        if (!Pattern.matches("[\\w]+", tagText)) {
            throw new IllegalArgumentException("String 'tagText' does not match pattern");
        }
        this.tagText = tagText;
    }

    /**
     *
     * @return value for this field, never {@code null}.
     */
    public String getTagText() {
        return tagText;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(new Object [] {
            tagText
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            UserGeneratedTag other = (UserGeneratedTag) obj;
            return (this.tagText == other.tagText) || (this.tagText.equals(other.tagText));
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static class Serializer extends StructSerializer<UserGeneratedTag> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(UserGeneratedTag value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("tag_text");
            StoneSerializers.string().serialize(value.tagText, g);
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public UserGeneratedTag deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            UserGeneratedTag value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_tagText = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("tag_text".equals(field)) {
                        f_tagText = StoneSerializers.string().deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_tagText == null) {
                    throw new JsonParseException(p, "Required field \"tag_text\" missing.");
                }
                value = new UserGeneratedTag(f_tagText);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            StoneDeserializerLogger.log(value, value.toStringMultiline());
            return value;
        }
    }
}
