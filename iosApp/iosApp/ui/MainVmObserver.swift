//
//  MainVmObserver.swift
//  iosApp
//
//  Created by  Faisal ur Rehman on 02/07/2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared

class MainVmObserver :ObservableObject{
  
    @Published var state: PostUiState = PostUiState.companion.initial()
    
    private let viewModelDelegate: PostListViewModelDelegate
    private var stateSubscription: KmmSubscription!
    
    init(viewModelDelegate: PostListViewModelDelegate) {
        self.viewModelDelegate = viewModelDelegate
        subscribeState()
    }
    
    deinit {
        viewModelDelegate.onCleared()
    }
    
    private func subscribeState() {
            stateSubscription = viewModelDelegate.uiState.subscribe(
                onEach: { state in
                    self.state = state!
                    
                },
                onCompletion: { error in
                    if let error = error {
                        print(error)
                    }
                }
            )
        }
    
    func loadPosts(){
        viewModelDelegate.loadPosts()
    }
    
}
