package org.example.automated_screenshot_generator;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.FileContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class UploadBasic {

    /**
     * Upload new file.
     *
     * @return Inserted file metadata if successful, {@code null} otherwise.
     * @throws IOException if service account credentials file not found.
     */

    public static String uploadBasic(String name,String path) throws IOException, GeneralSecurityException {
        // Load pre-authorized user credentials from the environment.
        // TODO(developer) - See https://developers.google.com/identity for
        // guides on implementing OAuth2 for your application.


        // Build a new authorized API client service.
        Drive service = DriveQuickstart.getDrive();
        // Upload file photo.jpg on drive.
        File fileMetadata = new File();
        fileMetadata.setName(name);
        // File's content.
        java.io.File filePath = new java.io.File(path);
        // Specify media type and file-path for file.

        FileContent mediaContent = new FileContent("image/jpeg", filePath);
        try {
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id")
                    .execute().setName("1_iFunded.jpg");

            System.out.println("File ID: " + file.getId());
            return file.getId();
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to upload file: " + e.getDetails());
            throw e;
        }
    }

}