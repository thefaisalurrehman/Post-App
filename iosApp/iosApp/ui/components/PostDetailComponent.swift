//
//  PostDetailComponent.swift
//  iosApp
//
//  Created by  Faisal ur Rehman on 02/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct PostDetailComponent: View {
    let posts: [Post]

    var body: some View {
        List(posts,id: \.self) { post in
            PostCell(post: post)
        }
        .listStyle(PlainListStyle())
        .frame(maxWidth: .infinity, maxHeight: .infinity)
    }
}

struct PostCell: View {
    var post: Post

    var body: some View {
        VStack(alignment: .leading) {
            Text(post.title)
                .padding(.horizontal, 16)
                .padding(.top, 12)
                .padding(.bottom, 4)
                .font(.title3)
                .foregroundColor(.blue)
                .multilineTextAlignment(.leading)
            Text(post.body)
                .padding(.horizontal, 16)
                .padding(.vertical, 4)
                .font(.body)
                .foregroundColor(.black)
                .multilineTextAlignment(.leading)
        }
    }
}



struct PostDetailComponent_Previews: PreviewProvider {
    static var previews: some View {
        PostDetailComponent(posts: [
            Post(id: 1, title: "Title 1", body: "Body 1",userId:1),
            Post(id: 1, title: "Title 2", body: "Body 2",userId:1)
        ])
    }
}

