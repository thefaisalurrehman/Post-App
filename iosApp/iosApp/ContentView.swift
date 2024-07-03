import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject var viewModel: MainVmObserver = MainVmObserver(viewModelDelegate: ViewModelProvider().getMovieViewModel())
    
    var body: some View {
        ZStack{
            if viewModel.state.isLoading{
                LoadingScreen()
            }
            
            if (viewModel.state.error != nil){
                ErrorScreen {
                    viewModel.loadPosts()
                }
            }
            
            if(!viewModel.state.posts.isEmpty){
                PostDetailComponent(posts: viewModel.state.posts)
            }
            
           
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
