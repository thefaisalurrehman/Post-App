//
//  LoadingScreen.swift
//  iosApp
//
//  Created by  Faisal ur Rehman on 02/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoadingScreen: View {
    var body: some View {
        VStack(
            alignment: .center,
            spacing: 16
        ) {
            ProgressView()
            Text("Loading ....")
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .padding(.vertical, 32)
        .padding(.horizontal, 32)
    }
}

struct LoadingScreen_Previews: PreviewProvider {
    static var previews: some View {
        LoadingScreen()
    }
}

