//
//  ErrorScreen.swift
//  iosApp
//
//  Created by  Faisal ur Rehman on 02/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorScreen: View {
    var onTryAgain: () -> Void

    var body: some View {
        VStack(
            alignment: .center,
            spacing: 16
        ) {
            Text(":(")
                .font(.title)
                .fontWeight(.black)
            Text("Cannot proceed your request, please try again!")
            Button(action: onTryAgain) {
                Text("Try again")
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .padding(.vertical, 32)
        .padding(.horizontal, 32)
    }
}

struct ErrorScreen_Previews: PreviewProvider {
    static var previews: some View {
        ErrorScreen(onTryAgain: {})
    }
}

