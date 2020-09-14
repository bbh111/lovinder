package com.lovinder.editprofile.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.lovinder.editprofile.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class FireBaseService {
    final String COL_NAME = "userInfor";

    public String saveUserInfor(User patient) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(patient.getId()).set(patient);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String updateUser(User user) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(user.getId()).set(user);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(String name) {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference writeResultApiFuture = firestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = writeResultApiFuture.get();
        DocumentSnapshot snapshot = null;

        try {
            snapshot = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        User user = null;
        if (snapshot.exists()) {
            user = snapshot.toObject(User.class);

        }
        return user;
    }
}
